<template>
  <div>
      <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
        <menu-bar/>
        <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
      </div>
      <my-profile v-if="member" :member="member"/>
      <p v-else>로딩중......</p>
      <my-board-list :myBoards="myBoards" @click="onDelete"/>
  </div>
</template>

<script>
import MyProfile from '@/components/member/MyProfile.vue'
import MenuBar from '@/components/MenuBar.vue'
import { mapActions, mapState } from 'vuex'
import MyBoardList from '@/components/board/MyBoardList.vue'
import axios from 'axios'

export default {
  name: 'MyProfilePage',
  props: {
    memberNo: {
        type: String,
        required: true
    }
  },
  components: {
    MyProfile,
    MenuBar,
    MyBoardList,
  },

  computed: {
    ...mapState(['member']),
    ...mapState(['myBoards']),
    
  },
  created() {
    this.fetchMember(this.memberNo)
      .catch(()=>{
          alert('로그인 정보 요청 실패')
          this.$router.push()
      })
    this.fetchBoardMyList(this.memberNo)
      .catch(()=>{
          alert('게시판 정보 요청 실패')
          this.$router.push()
      })
  },
  mounted () {
    this.fetchBoardMyList(this.memberNo)
  },
  methods: {
      ...mapActions(['fetchMember']),
      ...mapActions(['fetchBoardMyList']),
      onDelete() {
            const {boardNo} = this.board
            axios.delete(`http://localhost:7777/board/${boardNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    this.$router.push({name: 'HomeView'})
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
        }
    }
}
</script>

<style scoped>





</style>
