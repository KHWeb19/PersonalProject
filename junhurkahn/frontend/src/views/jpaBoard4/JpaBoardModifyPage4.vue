<template>
    <div align="center">
        <h2>사이트 아이디 수정</h2>
        <jpa-board-modify-form-4  v-if="jpaBoard4" :jpaBoard4="jpaBoard4" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardModifyForm4 from '@/components/jpaBoard4/JpaBoardModifyForm4.vue'
export default {
    name: 'JpaBoardModifyPage4',
    components: {
        JpaBoardModifyForm4
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['jpaBoard4'])
    },
    methods: {
        ...mapActions(['fetchJpaBoard4']),
        onSubmit (payload) {
            const { title, content, } = payload
            axios.put(`http://localhost:7777/62th/board4/${this.boardNo}`,
                { title, writer: this.jpaBoard4.writer, content, regDate: this.jpaBoard4.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'JpaBoardReadPage4',
                            params: { boardNo: res.data.boardNo.toString()}
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchJpaBoard4(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>