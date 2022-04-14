<template>
    <div id="videoBoard">
        <h2>영상게시판</h2>
        <board-list :boards="videoBoards" 
                    :registerPage="`${registerPage}`"
                    :accept="accept" 
                    :readPage="`${readPage}`"/>
        
    </div>
</template>

<script>


import { mapActions, mapState } from 'vuex'
import BoardList from '@/components/common/board/BoardList.vue'



export default {
    name: 'VideoBoardListPage',
    components: {
        BoardList  
    },
    data () {
        return {
            registerPage : 'VideoBoardRegisterPage',
            readPage: 'VideoBoardReadPage',
            accept: 'mp4'
        }
    },
    computed: {
        ...mapState(['videoBoards']),
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
    margin-bottom:50px;
    font-family: 'Nanum Brush Script', cursive;
}
a {
    text-decoration: none;
    margin-left: 1230px;
}

    
</style>