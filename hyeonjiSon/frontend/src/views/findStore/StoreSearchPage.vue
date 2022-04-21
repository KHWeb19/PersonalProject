<template>
<div>
    <store-search-list :searchList="searchList"/>
</div>
</template>

<script>
import StoreSearchList from '@/components/findStore/StoreSearchList.vue';

export default {
    name: "StoreSearchPage",
    components: {
        StoreSearchList

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