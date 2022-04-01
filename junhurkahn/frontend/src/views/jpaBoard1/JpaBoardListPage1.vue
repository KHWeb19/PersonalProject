<template>
<div align="center">
    <div id="board1">
        <h1>계좌번호</h1>
        <router-link :to="{ name: 'JpaBoardRegisterPage1' }">
            게시물 작성
        </router-link>
        <jpa-board-list-1 :jpaBoards1="jpaBoards1"/>
    </div>
</div>
</template>

<script>

import JpaBoardList1 from '@/components/jpaBoard1/JpaBoardList1.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'JpaBoardListPage1',
    components: {
      JpaBoardList1
    },
    computed: {
        ...mapState(['jpaBoards1'])
    },
    mounted () {
        this.fetchJpaBoardList1()
    },
    methods: {
        ...mapActions(['fetchJpaBoardList1'])
    }
}

</script>