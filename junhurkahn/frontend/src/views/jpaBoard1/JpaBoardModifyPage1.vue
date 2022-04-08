<template>
    <div align="center">
        <h2>계좌 번호 수정</h2>
        <jpa-board-modify-form-1  v-if="jpaBoard1" :jpaBoard1="jpaBoard1" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardModifyForm1 from '@/components/jpaBoard1/JpaBoardModifyForm1.vue'
export default {
    name: 'JpaBoardModifyPage1',
    components: {
        JpaBoardModifyForm1
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['jpaBoard1'])
    },
    methods: {
        ...mapActions(['fetchJpaBoard1']),
        onSubmit (payload) {
            const { title, content,writer1 } = payload
            axios.put(`http://localhost:7777/62th/board1/${this.boardNo}`,
                { title, writer: this.jpaBoard1.writer, content, writer1, regDate: this.jpaBoard1.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'JpaBoardReadPage1',
                            params: { boardNo: res.data.boardNo.toString()}
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchJpaBoard1(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>