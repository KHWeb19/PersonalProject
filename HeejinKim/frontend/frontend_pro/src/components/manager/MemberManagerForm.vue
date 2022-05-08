<template>
  <v-card class="cardStyle">
    <v-card-title  >
       <div class="cardtitle">Member List</div>
    </v-card-title>
       
    <v-row >
      <v-col>
        <div>
          <v-icon class="accountIcon"> mdi-account </v-icon>
          <b class="count">{{ registerMembers.length }}</b>
        </div>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-card>

          <div class="tableWrap">         
            <table class="memberTb" :items-per-page="itemsPerPage"  @page-count="pageCount = $event" >
              <tr style="height: 30px">
                <td class="grey lighten-5" width="15">memberNo</td>
                <td class="grey lighten-5" width="100">UserId</td>
                <td class="grey lighten-5" width="270">email</td> 
              </tr>

              <tr v-if="!registerMemberAuths || (registerMemberAuths.length == 0)"> 
              <tr  v-else v-for="member in registerMembers" :key="member.memberNo">
                <td>{{ member.memberNo }}</td>
                <td>{{ member.userId }}</td>
                <td>{{ member.email }}</td>

              </tr>
            </table>

            <table class="authTb">
              <tr style="height:30px">
                <td class="grey lighten-5" width="70">Auth</td>
              
              </tr>
              <tr v-if="!registerMemberAuths || (registerMemberAuths.length == 0)"> 
              <tr v-else v-for="memberAuth in registerMemberAuths" :key="memberAuth.memberNo">
                <td>{{ memberAuth.auth }}</td>
                
              </tr>
            </table>

            <table class="changeTb">
              <tr style="height:30px">
                <td class="yellow lighten-5" width="155">Setting</td>
              </tr>

              <tr v-if="!registerMemberAuths || (registerMemberAuths.length == 0)"> 
              <tr  v-else v-for="member in registerMembers" :key="member.memberNo">
              
                <td>
                
                  <v-btn text  style="font-size: 25px" 
                  :to="{ name: 'MemberManagerModifyPage', params: { memberNo: member.memberNo.toString() }, }">
                    <v-icon class="deleteIcon" color="red"> mdi-account-cog </v-icon></v-btn>
                      
                         <v-overlay :value="overlay"></v-overlay>
                </td>

                
              </tr>
            </table>
          </div>
        </v-card>
        <div class="text-center pt-2">
      <v-pagination class="grey lighten-4"
      v-model="page"
      :length="pageCount"
      ></v-pagination>
    </div>


      </v-col>
    </v-row>
  </v-card>
</template>

<script>
export default {
  name: "MemberManagerForm",
  props: {
    registerMembers: {
      type: Array,
    },
    registerMemberAuths: {
      type: Array,
    },
  },
  data () {
    return {
      search: '',
      page: 1,
      pageCount: 0,
      itemsPerPage: 5,
        switch1: true,
         overlay: false,
        
    }
  },
  watch: {
      overlay (val) {
        val && setTimeout(() => {
          this.overlay = false
        }, 2000)
      },
    },
  
}
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.cardtitle{
  margin-top: 30px;
  margin-left: 40px;
  position: relative;
  font-size: 40px;
  font-weight: bold;
  color: rgba(51, 51, 51, 0.712);
}
.count {
  font-size: 27px;
  color: rgba(51, 51, 51, 0.712);
  margin-left: 20px;
}
.accountIcon{
  margin-left: 1200px;
  margin-bottom:15px;
}
.tableWrap {
  display: flex;
  justify-content: center;
  margin-bottom: 50px;
}
.authTb {
  font-size: 20px;
  width: 20%;
  text-align: center;
  border-collapse: collapse;
}
.memberTb {
  font-size: 20px;
  width: 80%;
  text-align: center;
  border-collapse: collapse;
  
}
.changeTb{
  font-size: 20px;
  width: 20%;
  text-align: center;
  border-collapse: collapse;
}

td {
  border-bottom: 1px solid grey;
  height: 70px;
}


.cardStyle{

  font-family: 'Poiret One', cursive;
  margin: 5%;
  width:90%;
}
</style>