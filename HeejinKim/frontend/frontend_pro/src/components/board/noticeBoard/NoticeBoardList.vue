<template>
  <v-card class="cardStyle">

    <v-card-title>

      <h2>Notice</h2>

        <v-spacer></v-spacer>

      <v-text-field
      v-model="search"
      append-icon="mdi-magnify"      
      label="Search"
      single-line
      hide-details
      class="shrink pr-15"
      color="#e3c832">
    </v-text-field>
     
   
    </v-card-title>
   
<!--
     <v-row>
      <v-col>
        <v-btn v-if="loginAuth == 'Manager' " style="float: right" @click="writeBoard">
        <v-icon class="pen" color="black"> mdi-pencil-remove-outline </v-icon>
          </v-btn>
      </v-col>
      </v-row> listpage에서 해결함-->
      <v-row>
      <v-col class="together" >
        <div class="total">
          Total &nbsp;&nbsp;
          <span class="count">    
        {{ noticeBoards.length }}</span>
        </div>      
      </v-col>
     </v-row>

    <v-data-table 
      @click:row="showBoard"
      :headers="headers"
      :items="noticeBoards"
      :key="noticeBoards.boardNo"
      :page.sync="page"
      :items-per-page="itemsPerPage"
      class="table"
      hide-default-footer
      @page-count="pageCount = $event"
    ></v-data-table>

    <div class="text-center pt-2">
      <v-pagination class="grey lighten-4"
      v-model="page"
      :length="pageCount"
      ></v-pagination>
    </div>

  </v-card>
  
</template>


<script>
export default {
  name: "NoticeBoardList",
  props: {
    noticeBoards: {
      type: Array
    },
  },
 
  data() {
    return {
      search: '',
      page: 1,
      pageCount: 0,
      itemsPerPage: 9,
      headers: [
        {text:' No', align: 'center', value: 'boardNo', width:'10%',class: "grey lighten-4"}, 
        {text: 'Title', align: 'center', value: 'title', width: "45%",class: "grey lighten-4"},
        {text: 'Writer', align: 'center',value: 'writer', width:'10%',class: "grey lighten-4"},
        {text: 'Views', align: 'center',value: 'viewCount', width:'15%',class: "grey lighten-4"},
        {text: 'Date',align: 'center', value: 'regDate',width:'20%',class: "grey lighten-4"},
      ],
      session: "",
      loginAuth: "",
    }
  },

  methods: {
    showBoard(event, idx) {
      console.log("글 번호: " + idx.item.boardNo)
      this.$router.push({name: 'NoticeReadPage', params: {boardNo: String(idx.item.boardNo)}})
    },
  },
  
    
  
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&display=swap');


.table{
  cursor: pointer;
   font-family: 'Ubuntu', sans-serif;
}

.cardStyle{
  font-family: 'Ubuntu',  sans-serif;
  margin:  5% 5% 5% 5%; 
  width:1100px;
  
}
.v-data-table::v-deep th {
  font-size: 15px !important;
  font-family: 'Sunflower', sans-serif; 

}

.total{
   font-size:13pt;
}
.count{
  font-size:13pt;
}
.together{
  margin-left:920px;
  margin-bottom: 15px;

}
</style>