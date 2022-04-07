<template>
<div align="center">
    <div id="board">
        <h1>사이트 아이디 관리</h1>
        <router-link :to="{ name: 'JpaBoardRegisterPage4' }">
            게시물 작성
        </router-link>
        <jpa-board-list-4 :jpaBoards4="jpaBoards4"/>
    </div>
</div>
</template>

<script>
import JpaBoardList4 from '@/components/jpaBoard4/JpaBoardList4.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'JpaBoardListPage4',
    components: {
      JpaBoardList4
    },
    computed: {
        ...mapState(['jpaBoards4'])
    },
    mounted () {
        this.fetchJpaBoardList4()
    },
    methods: {
        ...mapActions(['fetchJpaBoardList4'])
    }
}
</script>