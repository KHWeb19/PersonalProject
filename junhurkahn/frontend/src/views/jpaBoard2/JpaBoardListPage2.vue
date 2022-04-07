<template>
<div align="center">
    <div id="board">
        <h1>장보기 목록</h1>
        <router-link :to="{ name: 'JpaBoardRegisterPage2' }">
            게시물 작성
        </router-link>
        <jpa-board-list-2 :jpaBoards2="jpaBoards2"/>
    </div>
</div>
</template>

<script>
import JpaBoardList2 from '@/components/jpaBoard2/JpaBoardList2.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'JpaBoardListPage2',
    components: {
      JpaBoardList2
    },
    computed: {
        ...mapState(['jpaBoards2'])
    },
    mounted () {
        this.fetchJpaBoardList2()
    },
    methods: {
        ...mapActions(['fetchJpaBoardList2'])
    }
}
</script>