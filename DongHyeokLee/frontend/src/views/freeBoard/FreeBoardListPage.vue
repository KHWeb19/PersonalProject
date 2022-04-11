<template>
    <div id="board" >
        <h2 id="title">자유게시판</h2>
        <free-board-list :freeBoards="freeBoards" />

 
    </div>
</template>

<script>


import { mapActions, mapState } from 'vuex'
import FreeBoardList from '@/components/freeBoard/FreeBoardList.vue'



export default {
    name: 'FreeBoardListPage',
    components: {
        FreeBoardList,
        
    },
    computed: {
        ...mapState(['freeBoards']),  
    },
    mounted () {
        if(!this.$store.state.isLogin){
            alert('로그인하세요')
            this.$router.push({name: "HomeView"});
        }else{
        this.fetchFreeBoardList()
        }   
    },
    methods: {
        ...mapActions(['fetchFreeBoardList'])
        
       
    }

}
</script>

<style scoped>

#board{
 height: 100vh;
}
a{
    text-decoration: none;
}

a:hover{
    text-decoration: none; 
}

#title {
    color: balck;
    text-align: center;
    padding: 30px;   
    background-color:#FFD54F;
}



</style>