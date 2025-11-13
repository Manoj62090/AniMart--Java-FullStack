document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll('.action-btn.cart').forEach(button => {
        button.addEventListener('click', async function() {
            const toyCard = this.closest('.toy-card');
            const toyId = toyCard.dataset.toyId;
            const toyName = toyCard.querySelector('h3').textContent;
            const userId = 1;

            await fetch(`http://localhost:8090/api/cart/add?userId=${userId}&toyId=${toyId}`, { method: 'POST' });
            alert(`${toyName} added to cart!`);
        });
    });

    document.querySelectorAll('.action-btn.wishlist').forEach(button => {
        button.addEventListener('click', async function() {
            const toyCard = this.closest('.toy-card');
            const toyId = toyCard.dataset.toyId;
            const toyName = toyCard.querySelector('h3').textContent;
            const userId = 1;

            await fetch(`http://localhost:8090/api/wishlist/add?userId=${userId}&toyId=${toyId}`, { method: 'POST' });
            alert(`${toyName} added to wishlist!`);
        });
    });
});
