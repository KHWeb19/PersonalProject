<template>
    <div align="center">
        <h2>생일관리 수정</h2>
        <jpa-board-modify-form-3  v-if="jpaBoard3" :jpaBoard3="jpaBoard3" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardModifyForm3 from '@/components/jpaBoard3/JpaBoardModifyForm3.vue'
export default {
    name: 'JpaBoardModifyPage3',
    components: {
        JpaBoardModifyForm3
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['jpaBoard3'])
    },
    methods: {
        ...mapActions(['fetchJpaBoard3']),
        onSubmit (payload) {
            const { title, content, } = payload
            axios.put(`http://localhost:7777/62th/board3/${this.boardNo}`,
                { title, writer: this.jpaBoard3.writer, content, regDate: this.jpaBoard3.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'JpaBoardReadPage3',
                            params: { boardNo: res.data.boardNo.toString()}
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchJpaBoard3(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>