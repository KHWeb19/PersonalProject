<template>
    <v-container>
        <v-btn class="writeBtn" @click="writeBoard" ><v-icon class="pen" color="black"> mdi-pencil </v-icon></v-btn>
      
        <v-row justify="center">
            <center-list-form :centers="centers"/>
        </v-row>
    </v-container>
</template>

<script>
import CenterListForm from '@/components/board/service/CenterListForm.vue'
import { mapState, mapActions } from 'vuex'
export default {
  components: { CenterListForm },
    name:'CenterList',
    computed: {
        ...mapState(['centers'])
    },
    mounted () {
        this.fetchCenterList()
    },
    methods: {
        ...mapActions(['fetchCenterList']),
        writeBoard(){
            this.$router.push('/service/register')
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