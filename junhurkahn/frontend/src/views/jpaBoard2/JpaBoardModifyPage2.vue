<template>
    <div align="center">
        <h2>장보기 목록 수정</h2>
        <jpa-board-modify-form-2  v-if="jpaBoard2" :jpaBoard2="jpaBoard2" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardModifyForm2 from '@/components/jpaBoard2/JpaBoardModifyForm2.vue'
export default {
    name: 'JpaBoardModifyPage2',
    components: {
        JpaBoardModifyForm2
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['jpaBoard2'])
    },
    methods: {
        ...mapActions(['fetchJpaBoard2']),
        onSubmit (payload) {
            const { title, content, } = payload
            axios.put(`http://localhost:7777/62th/board2/${this.boardNo}`,
                { title,  content, regDate: this.jpaBoard2.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'JpaBoardReadPage2',
                            params: { boardNo: res.data.boardNo.toString()}
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchJpaBoard2(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>