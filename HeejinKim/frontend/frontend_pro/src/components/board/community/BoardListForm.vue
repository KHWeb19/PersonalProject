<template>
  <v-card class="cardStyle">
    
    <v-card-title>

      <h2>Community</h2>

      <v-spacer></v-spacer>

      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"      
        label="Search"
        single-line
        hide-details
        class="shrink pr-15">
      </v-text-field>
      

     

    </v-card-title>

    <v-data-table 
      @click:row="showBoard"
      :headers="headers"
      :items="boards"
      :search="search"
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

//import axios from 'axios'

export default {

  name: "BoardListForm",
  props: {
    boards: {
      type: Array
    }
  },
  data () {
    return {
      search: '',
      page: 1,
      pageCount: 0,
      itemsPerPage: 9,
      
      headers: [
        {text:'글 번호', align: 'center', value: 'boardNo', width:'10%'}, 
        {text: '제목', align: 'center', value: 'title', width: "60%"},
        {text: '작성자', align: 'center',value: 'writer', width:'15%'},
        {text: '등록일자',align: 'center', value: 'regDate',width:'15%'},
      ],
    }
  },
  methods: {
    showBoard(event, idx) {
      console.log("글 번호: " + idx.item.boardNo)
      this.$router.push({name: 'BoardRead', params: {boardNo: String(idx.item.boardNo)}})
    },
    /*
    @click="keySearch"
    keySearch(){
      const {keyWord} = this
      console.log(keyWord)
      axios.post('http://localhost:7777/board/community/search', {keyWord})
      .then((res) => {
          console.log(res.data)
          this.$router.push({name: 'CommunityBoardSearchPage', params: { searchList: res.data }})
      })
      .catch (() => {
          alert('문제 발생!')
      })
            }*/
  }
}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&display=swap');


.table{
  cursor: pointer;

}

.cardStyle{

  font-family: 'Poiret One', cursive;
  font-weight: bold;
  margin: 30px;
  width:90%;
}
.v-data-table::v-deep th {
  font-size: 15px !important;
  font-family: 'Sunflower', sans-serif; 

}


</style>
