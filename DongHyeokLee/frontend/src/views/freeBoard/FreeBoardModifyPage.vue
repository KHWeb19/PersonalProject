<template>
    <div id="modify" align="center">
        <free-board-modify-form v-if="freeBoard" :freeBoard="freeBoard" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import FreeBoardModifyForm from '@/components/freeBoard/FreeBoardModifyForm.vue'

export default {
    name: 'FreeBoardModifyPage',
    components: {
        FreeBoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['freeBoard'])
    },
    methods: {
        ...mapActions(['fetchFreeBoard']),
        onSubmit (payload) {
            const { title, content } = payload
            console.log(title)
            axios.put(`http://localhost:7777/freeBoard/${this.boardNo}`,
                { title, writer: this.freeBoard.writer, content, regDate: this.freeBoard.regDate, count: this.freeBoard.count })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'FreeBoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchFreeBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}

</script>

<style scoped>

    
</style>