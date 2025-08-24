function setupCounter(textareaId, counterId, maxLength) {
    const textarea = document.getElementById(textareaId);
    const counter = document.getElementById(counterId);
    const max = maxLength;

    textarea.addEventListener("input", () => {
        const remaining = max - textarea.value.length;
        counter.textContent = `Character's description (${remaining}/256)`;
    });
}