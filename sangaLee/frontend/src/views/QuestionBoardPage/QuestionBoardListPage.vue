<template>

    <div id="QuestionBoard">
        <h1>질문 게시판</h1>
        <router-link :to="{ name: 'QuestionBoardRegisterPage' }">
            게시물 작성
        </router-link>
        <board-list :boards="boards"/>
    </div>

</template>


<script>

import DashBoardSideBar from '@/components/DashBoard/DashBoardSideBar.vue'

import QuestionBoardList from '@/components/QuestionBoard/QuestionBoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'QuestionBoardListPage',
    components: {
        DashBoardSideBar,
        QuestionBoardList
    },
    computed: {
        ...mapState(['boards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    }
}

</script>