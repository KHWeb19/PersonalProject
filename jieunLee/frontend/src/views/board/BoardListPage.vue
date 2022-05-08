<template>
        <board-list :boards="boards"/>
</template>

<script>
import BoardList from '@/components/board/BoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'BoardListPage',
    components: {
        BoardList
    },
    computed: {
        ...mapState(['boards']),
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList']),
    }
}
</script>