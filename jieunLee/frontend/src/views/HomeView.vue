<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
    <board-list :boards="boards" @click="onDelete" @submit="onSubmit"/>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import BoardList from '@/components/board/BoardList.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'HomeView',
  components: {
    MenuBar,
    BoardList
    },
        data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),

        }
    },
    computed: {
        ...mapState(['boards']),
        
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList']),
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
        }    
    }
}
</script>

<style>


</style>