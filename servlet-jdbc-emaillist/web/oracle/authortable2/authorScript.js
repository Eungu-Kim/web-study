document.addEventListener('DOMContentLoaded', function() {
    const rows = document.querySelectorAll('.data-row');
    const authorIdInput = document.getElementById('author_id');
    const authorNameInput = document.getElementById('author_name');
    const authorDescInput = document.getElementById('author_desc');
    const form = document.getElementById('authorForm');

    rows.forEach(function(row) {
        row.addEventListener('click', function() {
            if (this.classList.contains('selected')) {
                this.classList.remove('selected');
                authorIdInput.value = "";
                authorNameInput.value = "";
                authorDescInput.value = "";
                form.action = 'insertAuthor.jsp';
            } else {
                rows.forEach(function(r) {
                    r.classList.remove('selected');
                });

                this.classList.add('selected');

                const authorId = this.getAttribute('data-id');
                const authorName = this.getAttribute('data-name');
                const authorDesc = this.getAttribute('data-desc');

                authorIdInput.value = authorId;
                authorNameInput.value = authorName;
                authorDescInput.value = authorDesc;

                if (authorId) {
                    form.action = 'updateAuthorTable.jsp'
                } else {
                    form.action = 'insertAuthor.jsp'
                }

            }
        });
    });
});