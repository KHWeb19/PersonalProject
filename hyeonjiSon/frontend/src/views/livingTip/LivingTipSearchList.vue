<template>
<div class="board_wrap">

   <v-container  v-if="this.$store.state.userInfo == null">
      <h1> 로그인 후 이용 가능한 페이지 입니다. </h1>
   </v-container>

<v-container v-if="this.$store.state.userInfo != null">
   <br>
         <tip-search-list :searchList="searchList"/>
   <br>

</v-container>
</div>
</template>

<script>
import TipSearchList from '@/components/livingTip/TipSearchList.vue'

export default {
   name: 'LivingTipSearchList',  
   components: {
       TipSearchList
   },
   props: {
       searchList: {
           type:Array
       }
   },
   data () {
      return {
          keyWord: ''
}
   }
}
</script>

<style scoped>
#search {
   width: 800px;
}
</style>