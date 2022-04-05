<template>
    <div align="center">
        <h2>Vue + Spring 게시판 읽기</h2>
        <board-read v-if="board" :board="board"/>
        <p v-else>로딩중 ....... </p>
        <!--v-for로  e7의 인자들을 params에 배치?
        권한 auto 추출활용가능-->
        <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'BoardListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>
<script>
export default {
    name:'Kategorie1Read',
    /* props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        BoardRead
    },
    computed: {
        ...mapState(['board'])
    },
    created () {
        this.fetchBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onDelete () {
            const { boardNo } = this.board
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'BoardListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}*/
}
</script>