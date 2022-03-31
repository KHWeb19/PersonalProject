<template>
     <v-text-field
          class="hidden-xs-only"  
          append-icon="mdi-magnify"
          placeholder="상품을 검색하세요"
          flat
          hide-details
          solo
          dense
          background-color="grey lighten-4"
     />
</template>
<script>
export default ({
   name: 'search'
})
</script>
<style scoped>
.v-text-field {
    max-width: 400px;
}
</style>

