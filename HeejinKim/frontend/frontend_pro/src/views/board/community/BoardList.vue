<template>
    <v-container>
        <v-btn class="writeBtn" @click="writeBoard" ><v-icon class="pen" color="black"> mdi-pencil </v-icon></v-btn>
      
        <v-row justify="center">
            <board-list-form :boards="boards"/>
        </v-row>
    </v-container>
</template>

<script>
import BoardListForm from '@/components/board/community/BoardListForm.vue'
import { mapState, mapActions } from 'vuex'
export default {
  components: { BoardListForm },
    name:'BoardList',
    computed: {
        ...mapState(['boards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList']),

        writeBoard(){
            this.$router.push('/community/register')
        }
        
    }
}
</script>

<style scoped>

.writeBtn{
  margin-top:30px;
  left:90%;
  height:40px;
  width:40px;    
}

</style>