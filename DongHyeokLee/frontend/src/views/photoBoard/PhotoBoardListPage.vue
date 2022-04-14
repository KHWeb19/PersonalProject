<template>
    <div id="photo-board">
        <h2>사진게시판</h2>
        <board-list :boards="photoBoards" 
                    :accept="accept" 
                    :registerPage="`${registerPage}`"
                    :readPage="`${readPage}`"/>
    </div>   
</template>

<script>


import { mapActions, mapState } from 'vuex'
import BoardList from '@/components/common/board/BoardList.vue'



export default {
    name: 'PhotoBoardListPage',
    components: {
        BoardList,     
    },
    data () {
        return {
            registerPage : 'PhotoBoardRegisterPage',
            readPage: 'PhotoBoardReadPage',
            accept: 'jpg'
        }
    },
    computed: {
        ...mapState(['photoBoards'])
    },
    mounted () {
        if(!this.$store.state.isLogin){
            alert('로그인하세요')
            this.$router.push({name: "HomeView"});
        }else{
        this.fetchPhotoBoardList()
        }  
    },
    methods: {
        ...mapActions(['fetchPhotoBoardList'])
       
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