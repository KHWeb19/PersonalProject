<template>
  
  <v-container>
    
      <v-card class="table" style="width: 800px">

      <v-row justify="center" >
        <v-col cols="3" class="label">Title</v-col>
        <v-col>
          <v-text-field rounded style="width:200px" readonly :value="noticeBoard.title"/>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="3" class="label"> Writer</v-col>
        <v-col>
          <v-text-field rounded style="width:150px" readonly :value="noticeBoard.writer"/>
        </v-col>
      </v-row>

      <v-row>
          <v-col cols="3" class="label"> Date</v-col>
          <v-col cols="5">
            <v-text-field class="date" rounded readonly :value="noticeBoard.regDate"/>
          </v-col>
          
      </v-row>

      <v-row>
        <v-col cols="3">
            <v-icon class="viewIcon"> mdi-account-eye-outline </v-icon>
        </v-col>
        <v-col cols="3">               
            <v-text-field class="viewNum" rounded readonly :value="noticeBoard.viewCount"/>
        </v-col> 
  
        <v-col v-if="this.loginAuth == 'Manager'">

          <router-link :to="{name:'NoticeModifyPage', params:{ boardNo: noticeBoard.boardNo.toString()}}" style="text-decoration:none">
            <v-icon class="edit" color="#dbc34d"> mdi-file-edit </v-icon>
          </router-link>  

        </v-col>

        <v-col v-if="this.loginAuth == 'Manager'">
          <v-dialog v-model="dialogDelete" width="460">
            <template v-slot:activator="{ on, attrs }">
              <v-btn text class="deleteBtn" v-bind="attrs" v-on="on"  color="red">
                <v-icon class="deleteIcon"> mdi-trash-can-outline </v-icon>
              </v-btn>
            </template>

            <v-card>
              <v-card-text class="pt-5">
                <h3>Are you sure to delete your files?</h3> 
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn @click="onDelete" text> Delete </v-btn>

                <v-btn color="grey" text @click="dialogDelete = false">Cancle</v-btn>

              </v-card-actions>
            </v-card>

          </v-dialog>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12">
          <v-textarea cols="80" rows="20" outlined color="grey"
          style="white-space:pre-line"  class="mt-3" readonly
          :value="noticeBoard.content">
          </v-textarea>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="3">
          <v-btn @click="goList" class="listBtn" text>
              <v-icon class="listIcon" justify="center"> mdi-keyboard-backspace</v-icon>
            </v-btn>
        </v-col>   
      </v-row>
     
      </v-card>

  </v-container>
</template>

<script>
import axios from "axios"
export default {
  name: "NoticeReadForm",
  props: {
    noticeBoard: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      session: "",
      userId: "",
      dialogDelete: false,
      loginAuth: "",
  
    }
  },
  created() {
   if (this.$store.state.session != null) {
      this.loginAuth = this.$store.state.auth.auth
      this.userId =  this.$store.state.session.userId
    }
  },
  methods: {
    goList() {
      this.$router.push("/noticeList")
    },
    onDelete() {
      const { boardNo } = this.noticeBoard;
      axios
        .delete(`http://localhost:7777/noticeBoard/${boardNo}`)
        .then(() => {
          alert("Done! Files deleted successfully")
          this.$router.push({ name: "NoticeListPage" })
        })
        .catch(() => {
          alert("삭제 실패");
        })
    },
  
  },
}
</script>

<style scoped>

@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&family=Ubuntu:wght@300&display=swap");
.label{
    font-family: 'Ubuntu', sans-serif; 
    font-size: 17pt;
    margin-right:5%;
    text-align: center;
    padding-top: 25px; 
}
.table{
    background-color: #f3f3f3;
    padding: 5% 10% 5% 10%;
    margin-left:auto;
    margin-right:auto;
}
.modifyBtn{
    color:rgba(214, 86, 103, 0.596);  
}
.v-text-field, .v-textarea{
    font-family: 'Ubuntu', sans-serif;
}
.addImg {
    position: relative;
    max-height: 400px;
    max-width: 500px;
}
.edit{
  margin-top:15px;
  margin-left:155px;
 
  
}
.deleteBtn{
  margin-top:9px;
}

.viewIcon{
  margin-left:50px;
  margin-top:20px;
 
}
.viewNum{
  margin-left:35px;
 
}.listIcon{
  margin-bottom: 3px;
}
.listBtn{
  
  margin-bottom: 30px;
 
}
</style>