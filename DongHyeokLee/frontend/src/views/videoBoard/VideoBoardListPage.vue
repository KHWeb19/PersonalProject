<template>
    <div id="photoBoard">
        <h2>영상게시판</h2>
        <div>
        <video-board-list :videoBoards="videoBoards"/>
        </div>
    </div>
</template>

<script>


import { mapActions, mapState } from 'vuex'
import VideoBoardList from '@/components/videoBoard/VideoBoardList.vue'



export default {
    name: 'VideoBoardListPage',
    components: {
        VideoBoardList
        
    },
    computed: {
        ...mapState(['videoBoards'])
        
    },
    mounted () {
        this.fetchVideoBoardList()
        
    },
    methods: {
        ...mapActions(['fetchVideoBoardList'])
       
    }

}
</script>

<style scoped>

h2 {
   text-align: center;
    padding:20px;
    background-color: #FFD54F;
}
a {
    text-decoration: none;
    margin-left: 1230px;
}

    
</style>