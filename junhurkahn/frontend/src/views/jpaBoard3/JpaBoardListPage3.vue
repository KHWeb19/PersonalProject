<template>
<div align="center">
    <div id="board">
        <h1>생일관리</h1>
        <router-link :to="{ name: 'JpaBoardRegisterPage3' }">
            게시물 작성
        </router-link>
        <jpa-board-list-3 :jpaBoards3="jpaBoards3"/>
    </div>
</div>
</template>

<script>
import JpaBoardList3 from '@/components/jpaBoard3/JpaBoardList3.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'JpaBoardListPage3',
    components: {
      JpaBoardList3
    },
    computed: {
        ...mapState(['jpaBoards3'])
    },
    mounted () {
        this.fetchJpaBoardList3()
    },
    methods: {
        ...mapActions(['fetchJpaBoardList3'])
    }
}
</script>