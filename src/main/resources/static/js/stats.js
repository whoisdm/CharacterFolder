function generateStats(groupId) {
    const inputs = document.querySelectorAll(`#${groupId} .form-control`);
    inputs.forEach(input => {
        let rolls = [];
        for (let i = 0; i < 4; i++) {
            rolls.push(Math.floor(Math.random() * 6) + 1);
        }
        rolls.sort((a, b) => a - b);
        input.value = rolls[1] + rolls[2] + rolls[3];
    });
}