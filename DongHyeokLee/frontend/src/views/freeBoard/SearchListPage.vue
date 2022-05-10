<template>
    <div>
      <search-list :searchList="searchList" />  
    </div>
</template>

<script>

import SearchList from "@/components/freeBoard/SearchList.vue"

export default {
    props:{
        searchList: {
            type: Array,
            required: true
        }
    },
      components: {
            SearchList
        }
    
}
</script>