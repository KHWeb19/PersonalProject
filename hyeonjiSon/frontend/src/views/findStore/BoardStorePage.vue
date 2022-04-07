<template>
<div id="storeBoard">
   <h1> Recycle Store Page </h1>
   <router-link :to="{ name: 'BoardStoreRegisterPage'}">
      게시물 작성
   </router-link> <!-- 로그인하지 않으면 작성 불가하다는 alert 뜨거나 버튼이 보이지 않게 해야 함 -->

   <store-board-list : storeBoards="storeBoards"/>
</div>
</template>

<script>
import StoreBoardList from '@/components/findStore/StoreBoardList.vue'

export default {
   name: 'BoardStorePage',
   components: {
      StoreBoardList
   },
    
}
</script>