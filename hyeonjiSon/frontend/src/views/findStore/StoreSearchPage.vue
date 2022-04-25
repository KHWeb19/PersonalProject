<template>
<div>
    <store-search-list :searchList="searchList"/>
</div>
</template>

<script>
import StoreSearchList from '@/components/findStore/StoreSearchList.vue';

export default {
    name: "storeSearchPage",
    components: {
        StoreSearchList

    },
    data() {
        return {
            keyWord: ''
        }
    },    
    props: {
        searchList: {
            type: Array,
            required: true
        }
    },
}
</script>

<style scoped>

</style>