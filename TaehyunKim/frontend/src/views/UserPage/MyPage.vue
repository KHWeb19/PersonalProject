<template>
    <v-container class="the-container">
          <v-card style="margin: auto; width: 50%" v-if="user">
              <div class="first-div">
                  <span class="first-div__username">Hello, {{user.username}}!</span>
                  <img src="../../assets/img/userimg.png" width="100px">
              </div>
              <div class="ma-4 pa-4">
                <v-row no-gutters>
                    <v-col cols="6">First Name</v-col>
                    <v-col cols="6">Last Name</v-col>
                </v-row>
                <v-row no-gutters>
                    <v-col cols="6">{{user.first_name}}</v-col>
                    <v-col cols="6">{{user.last_name}}</v-col>
                </v-row>
                <hr class="mb-5">
                <v-row no-gutters>
                    <v-col cols="12">Email</v-col>
                </v-row>
                <v-row no-gutters>
                    <v-col cols="12">{{user.email}}</v-col>
                </v-row>
                <hr class="mb-5">
                <v-row no-gutters>
                    <v-col cols="6">Register Date</v-col>
                    <v-col cols="6">Roles</v-col>
                </v-row>
                <v-row no-gutters>
                    <v-col cols="6">{{dateInFormat}}</v-col>
                    <v-col cols="6">{{user.roles[0].name}}</v-col>
                </v-row>
                <hr class="mb-5">
              </div>
          </v-card>
    </v-container>
</template>

<script>
import {mapActions, mapState} from 'vuex'
import moment from 'moment'

export default{
    computed:{
        ...mapState(['user']),
        dateInFormat(){
            let a = moment(this.user.register_date)
            return a.format("YYYY-MM-DD HH:mm:ss")
        }
    },

    methods:{
        ...mapActions(['get_user'])
    },

    mounted(){
        this.get_user()
    }
}
</script>

<style scoped>
    .the-container{
    margin: 20px 0 10px 0;
    padding: 10px;
    box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
    }
    .first-div{
        display: flex;
        justify-content: space-evenly;
        align-items: center;
        margin-bottom: 10px;
    }

    .first-div__username{
        font-size: 30px;
        font-weight: bold;
    }


</style>
