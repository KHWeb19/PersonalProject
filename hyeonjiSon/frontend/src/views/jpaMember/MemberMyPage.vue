<template>
<!-- BoardRead페이지를 참고하여 작성 -->
  <div>
      <h2>나의 정보 확인하기</h2>
      <my-page-form v-if="member" :member="member"/>
         <p v-else>로딩중 ....... </p>

         <v-btn backgrondcolor: blue>
            <v-on @click="passwordCheck">
            정보 수정
            </v-on>
         </v-btn>

      <delete-member-pop-up/> <!--ㅡmyPopup으로 이름 바꾸기 -->

      <v-btn>회원 탈퇴</v-btn>
      <button @click="onDelete">회원 탈퇴</button>
  </div>
</template>

<script>
import MyPageForm from '@/components/jpaMember/MyPageForm.vue'
import DeleteMemberPopUp from '@/components/jpaMember/MyPopUp.vue'

export default {
     name: "MemberMyPage",
  components: {
     MyPageForm,
     DeleteMemberPopUp
  },
  computed: {
  },
  created(){
     this.fetchMember(this.memberNo)
            .catch(() => {
               alert('나의 정보 요청 실패!')
               this.$router.push()
            })
  },
  methods: {
  },
}
</script>