<template>
    <div align="center">
        <notice-read-form v-if="noticeBoard" :noticeBoard="noticeBoard"/>
        <p v-else>로딩중 ....... </p>

        <div v-if="this.userInfo.id === 'admin'">
            <v-btn plain class="basil--text" router-link :to="{ name: 'NoticeModifyPage', params: { boardNo } }">
                수정
            </v-btn>

            <v-btn plain class="basil--text" @click="onDelete">
                삭제
            </v-btn>

            <v-btn plain class="basil--text" router-link :to="{ name: 'NoticeListPage' }">
                돌아가기
            </v-btn>
        </div>

        <v-btn  v-else plain class="basil--text" router-link :to="{ name: 'NoticeListPage' }">
            돌아가기
        </v-btn>
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'

import NoticeReadForm from '@/components/notice/NoticeReadForm.vue'

export default {
    name: 'NoticeReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        NoticeReadForm
    },
    computed: {
        ...mapState(['noticeBoard','userInfo'])
    },
    created () {
        this.fetchNoticeBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.boardNo)
                    // this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchNoticeBoard']),
        onDelete () {
            const { boardNo } = this.noticeBoard
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/notice/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'NoticeListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}

</script>