<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
        <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        <p v-else>로딩중......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import MenuBar from '@/components/MenuBar.vue'
import BoardModifyForm from '@/components/board/BoardModifyForm'

export default {
    name: 'BoardModifyPage',
    components: {
        MenuBar,
        BoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            require: true
        }
    },
    data () {
        return {
                        loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
        }
    },
    computed: {
        ...mapState(['board'])
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onSubmit(payload) {
            const {memberNo, boardImage, content} = payload
            axios.put(`http://localhost:7777/board/${memberNo}/${this.boardNo}`, 
            {member: this.board.member, boardImage, writer: this.board.writer, content, regDate: this.board.regDate})
                .then(res => {
                    alert('게시물 수정 성공')
                    console.log(this.board)
                    this.$router.push({
                        name: 'BoardReadPage',
                        params: {boardNo: res.data.boardNo.toString()}
                    })
                })
                .catch(()=>{
                    alert('게시물 수정 실패')
                })
        }
    },
    created() {
        this.fetchBoard(this.boardNo)
            .catch(()=> {
                alert('게시물 조회 실패')
                this.$router.back()
            })
    }
}
</script>