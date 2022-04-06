<template>
<!-- BoardRead페이지를 참고하여 작성 -->
  <div>
      <h2>Vue + Spring 게시판 읽기</h2>
      <member-read v-if="member" :member="member"/>
         <p v-else>로딩중 ....... </p>

      <router-link :to="{ name: 'MemberModifyPage', params: { memberNo } }">
         정보 수정
      </router-link>

      <button @click="onDelete">회원 탈퇴</button>
      
      <router-link :to="{ name: 'MemberListPage' }">
         게시물 보기
      </router-link>
  </div>
</template>

<script>
export default {
    
}
</script>