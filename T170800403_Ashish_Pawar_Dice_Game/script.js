let players = [];
let currentPlayer = 0;
let round = 1;
let maxRounds = 5;
let numberOfPlayers = 3;
let turnNumber = 1;
let lastRoll = null;
let soundOn = true;
let rolling = false;
let playerStreak = 0;

const diceFaces = ["⚀", "⚁", "⚂", "⚃", "⚄", "⚅"];

document.addEventListener("DOMContentLoaded", () => {
  selectPlayers(3);
  selectRounds(5);
});

function selectPlayers(count) {
  numberOfPlayers = count;

  document.getElementById("players3").classList.toggle("selected", count === 3);
  document.getElementById("players4").classList.toggle("selected", count === 4);

  const area = document.getElementById("nameInputs");
  area.innerHTML = "";

  for (let i = 0; i < count; i++) {
    area.innerHTML += `
      <input
        class="name-input"
        id="name${i}"
        maxlength="16"
        placeholder="Player ${i + 1} name"
        value="Player ${i + 1}"
      >
    `;
  }
}

function selectRounds(count) {
  maxRounds = count;
  document.querySelectorAll(".round-btn").forEach(button => {
    button.classList.remove("selected");
  });

  document.querySelectorAll(".round-btn").forEach(button => {
    if (button.textContent == count) {
      button.classList.add("selected");
    }
  });
}

function startGame() {
  players = [];

  for (let i = 0; i < numberOfPlayers; i++) {
    let name = document.getElementById(`name${i}`).value.trim();

    if (name === "") {
      name = `Player ${i + 1}`;
    }

    players.push({
      name: name,
      score: 0,
      rolls: [],
      sixes: 0
    });
  }

  currentPlayer = 0;
  round = 1;
  turnNumber = 1;
  lastRoll = null;
  playerStreak = 0;

  document.getElementById("setup").classList.add("hidden");
  document.getElementById("winner").classList.add("hidden");
  document.getElementById("game").classList.remove("hidden");

  document.getElementById("dice").textContent = "⚀";
  document.getElementById("rollNumber").textContent = "Ready?";
  document.getElementById("rollBtn").disabled = false;

  render();
  showToast("Battle started! Good luck 🎲");
}

function render() {
  document.getElementById("round").textContent = `${round} / ${maxRounds}`;
  document.getElementById("turn").textContent = `${players[currentPlayer].name}'s Turn`;
  document.getElementById("turnNumber").textContent = turnNumber;
  document.getElementById("message").textContent =
    `${players[currentPlayer].name}, roll the dice!`;

  const totalTurns = maxRounds * players.length;
  const completedTurns = turnNumber - 1;
  const progress = Math.min((completedTurns / totalTurns) * 100, 100);
  document.getElementById("progressBar").style.width = `${progress}%`;

  renderPlayers();
  updateStats();
}

function renderPlayers() {
  const area = document.getElementById("players");
  area.innerHTML = "";

  const highest = Math.max(...players.map(p => p.score));

  players.forEach((player, index) => {
    const div = document.createElement("div");

    let classes = "player";
    if (index === currentPlayer) classes += " active";
    if (player.score === highest && highest > 0) classes += " leader";

    div.className = classes;

    div.innerHTML = `
      ${player.score === highest && highest > 0 ? '<div class="crown">👑</div>' : ""}
      <div class="player-name">${escapeHtml(player.name)}</div>
      <div class="player-tag">${index === currentPlayer ? "⚡ Playing now" : "Waiting"}</div>
      <div class="score">${player.score}</div>
    `;

    area.appendChild(div);
  });
}

function rollDice() {
  if (rolling) return;

  rolling = true;
  document.getElementById("rollBtn").disabled = true;

  const dice = document.getElementById("dice");
  dice.classList.remove("rolling");
  void dice.offsetWidth;
  dice.classList.add("rolling");

  playSound("roll");

  let animationCount = 0;
  const animation = setInterval(() => {
    const fake = Math.floor(Math.random() * 6);
    dice.textContent = diceFaces[fake];
    animationCount++;

    if (animationCount >= 7) {
      clearInterval(animation);

      const result = Math.floor(Math.random() * 6) + 1;
      finishRoll(result);
    }
  }, 90);
}

function finishRoll(result) {
  const player = players[currentPlayer];

  player.score += result;
  player.rolls.push(result);

  if (result === 6) {
    player.sixes++;
    playerStreak++;
  } else {
    playerStreak = 0;
  }

  lastRoll = result;

  const dice = document.getElementById("dice");
  dice.textContent = diceFaces[result - 1];

  document.getElementById("rollNumber").textContent = `You rolled ${result}`;
  document.getElementById("message").textContent =
    `${player.name} rolled ${result}! +${result} points`;

  if (result === 6) {
    document.getElementById("streak").textContent =
      playerStreak > 1 ? `🔥 ${playerStreak} sixes!` : "🔥 SIX!";
    showToast("Amazing! You rolled a SIX! 🔥");
    playSound("six");
  } else {
    document.getElementById("streak").textContent = "";
    playSound("score");
  }

  renderPlayers();
  updateStats();

  setTimeout(nextTurn, 750);
}

function nextTurn() {
  currentPlayer++;
  turnNumber++;

  if (currentPlayer >= players.length) {
    currentPlayer = 0;
    round++;
    playerStreak = 0;

    if (round > maxRounds) {
      showWinner();
      return;
    }
  }

  rolling = false;
  document.getElementById("rollBtn").disabled = false;
  render();
}

function updateStats() {
  const highest = Math.max(...players.map(p => p.score));
  const leaders = players.filter(p => p.score === highest);

  document.getElementById("highestScore").textContent = highest;
  document.getElementById("lastRoll").textContent = lastRoll ?? "—";
  document.getElementById("leaderName").textContent =
    highest === 0 ? "—" : leaders.length > 1 ? "Tie" : leaders[0].name;
}

function showWinner() {
  document.getElementById("game").classList.add("hidden");
  document.getElementById("winner").classList.remove("hidden");

  const highest = Math.max(...players.map(p => p.score));
  const winners = players.filter(p => p.score === highest);

  if (winners.length === 1) {
    document.getElementById("winnerText").textContent =
      `🎉 ${winners[0].name} Wins!`;
    document.getElementById("winnerSubtext").textContent =
      `${highest} points — what a battle!`;
    playSound("win");
  } else {
    document.getElementById("winnerText").textContent = "🤝 It's a Tie!";
    document.getElementById("winnerSubtext").textContent =
      `${highest} points each. Nobody gave up!`;
    playSound("win");
  }

  const scoreArea = document.getElementById("finalScores");
  scoreArea.innerHTML = "";

  [...players]
    .sort((a, b) => b.score - a.score)
    .forEach((player, index) => {
      scoreArea.innerHTML += `
        <div class="final-score ${player.score === highest ? "winner-row" : ""}">
          <span>${index + 1}. ${escapeHtml(player.name)}</span>
          <span>${player.score}</span>
        </div>
      `;
    });

  createConfetti();
}

function createConfetti() {
  const area = document.getElementById("confetti");
  area.innerHTML = "";

  for (let i = 0; i < 55; i++) {
    const piece = document.createElement("div");
    piece.className = "confetti-piece";
    piece.style.left = Math.random() * 100 + "%";
    piece.style.animationDelay = Math.random() * 1.5 + "s";
    piece.style.transform = `rotate(${Math.random() * 360}deg)`;
    piece.style.background = ["#8b5cf6", "#22d3ee", "#fbbf24", "#fb7185", "#34d399"][
      Math.floor(Math.random() * 5)
    ];
    area.appendChild(piece);
  }
}

function playAgain() {
  startGame();
}

function resetGame() {
  players = [];
  rolling = false;

  document.getElementById("game").classList.add("hidden");
  document.getElementById("winner").classList.add("hidden");
  document.getElementById("setup").classList.remove("hidden");

  selectPlayers(numberOfPlayers);
  selectRounds(maxRounds);
}

function toggleSound() {
  soundOn = !soundOn;
  document.getElementById("soundBtn").textContent = soundOn ? "🔊" : "🔇";
  showToast(soundOn ? "Sound on 🔊" : "Sound off 🔇");
}

function playSound(type) {
  if (!soundOn) return;

  try {
    const AudioContext = window.AudioContext || window.webkitAudioContext;
    if (!AudioContext) return;

    const ctx = new AudioContext();
    const oscillator = ctx.createOscillator();
    const gain = ctx.createGain();

    oscillator.connect(gain);
    gain.connect(ctx.destination);

    if (type === "roll") {
      oscillator.frequency.value = 180;
      gain.gain.value = 0.04;
      oscillator.start();
      oscillator.stop(ctx.currentTime + 0.08);
    } else if (type === "six") {
      oscillator.frequency.value = 700;
      gain.gain.value = 0.06;
      oscillator.start();
      oscillator.stop(ctx.currentTime + 0.18);
    } else if (type === "win") {
      oscillator.frequency.value = 880;
      gain.gain.value = 0.07;
      oscillator.start();
      oscillator.stop(ctx.currentTime + 0.35);
    } else {
      oscillator.frequency.value = 420;
      gain.gain.value = 0.04;
      oscillator.start();
      oscillator.stop(ctx.currentTime + 0.10);
    }
  } catch (error) {
    // Sound is optional; the game still works without it.
  }
}

function showToast(text) {
  const toast = document.getElementById("toast");
  toast.textContent = text;
  toast.classList.add("show");

  setTimeout(() => {
    toast.classList.remove("show");
  }, 1600);
}

function escapeHtml(text) {
  return text
    .replaceAll("&", "&amp;")
    .replaceAll("<", "&lt;")
    .replaceAll(">", "&gt;")
    .replaceAll('"', "&quot;")
    .replaceAll("'", "&#039;");
}
