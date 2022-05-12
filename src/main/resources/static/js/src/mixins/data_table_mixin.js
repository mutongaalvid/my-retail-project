export default {
    data() {
        return {
            page: 0,
            pageSize: 10,
            pageable: false
        }
    },
    methods: {
        goToNext() {
            this.page++;
            this.fetchRecords();
        },
        goToPrevious() {
            this.page--;
            this.fetchRecords();
        },
        onPaginationChanged(pageSize) {
            this.pageSize = pageSize;
            this.page = 0;
            this.fetchRecords();
        },

    }
}