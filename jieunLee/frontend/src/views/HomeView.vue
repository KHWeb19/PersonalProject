<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
    <!-- <my-likes-list :loginLikes="loginLikes"/> -->
    <board-list :boards="boards" :loginLikes="loginLikes" @click="onDelete" @submit="onSubmit"/>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import BoardList from '@/components/board/BoardList.vue'
// import MyLikesList from '@/components/member/MyLikesList.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'HomeView',
  components: {
    MenuBar,
    BoardList,
    // MyLikesList
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
        }
    },
    computed: {
        ...mapState(['boards']),
            ...mapState(['loginLikes']),
        // ...mapState(['twoComments']),
    },
    // created() {
    //       this.fetchLoginLikes(this.loginInfo.memberNo)
    // },
    mounted () {
        this.fetchBoardList()
            this.fetchLoginLikes(this.loginInfo.memberNo)
        // this.fetchTwoCommentList(this.boardNo)
    },
    methods: {
        ...mapActions(['fetchBoardList']),
              ...mapActions(['fetchLoginLikes']),
        // ...mapActions(['fetchTwoCommentList']),
        onDelete(payload) {
            const {boardNo} = payload
            axios.delete(`http://localhost:7777/board/${boardNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    history.go(0);
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
        },
        onSubmit(payload) {
            const { boardNo, content} = payload
            axios.post(`http://localhost:7777/comment/register/${boardNo}`, {boardNo, writer: this.loginInfo.memberName, content})
                .then(() => {
                    alert('댓글 등록 성공!')
                    history.go(0);
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        },
        onLikes(payload) {
            const {boardNo, memberNo} = payload
            axios.post(`http://localhost:7777/likes/${boardNo}/${memberNo}`, {boardNo, boardCheck: boardNo, memberNo})
                .then(() => {
                    history.go(0);
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        },
    }
}
</script>

<style>


</style>