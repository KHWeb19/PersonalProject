<template>
  <v-container fluid>
    <MainCategory/>
    <v-row>
      <v-spacer></v-spacer>
      <v-col>
        <v-text-field dense outlined label="장소 검색" full-width :style="{marginTop:'10px'}" v-model="searchBoard" v-on:keyup.enter="sendSearchBoard"/>
      </v-col>
      <v-col>
        <v-btn :style="{marginTop:'10px'}" @click="sendSearchBoard"><v-icon>mdi-magnify</v-icon></v-btn>
      </v-col>
    </v-row>
    <v-row>
      <BoardListForm :boardList="boardList"></BoardListForm>
    </v-row>
  </v-container>
</template>


<script>
import MainCategory from "@/components/MainCategory";
import BoardListForm from "@/components/board/BoardListForm";
import {mapActions, mapState} from "vuex";
import axios from "axios";
import {FETCH_BOARD_LIST} from "@/store/mutation-types";

export default {
  name: "BoardView",
  components: {BoardListForm, MainCategory},
  data(){
    return{
      searchBoard: '',
    }
  },
  computed: {
    ...mapState(['boardList'])
  },
  methods:{
    ...mapActions(['fetchBoardList']),
    sendSearchBoard(){
      const {searchBoard} = this
      console.log(searchBoard)

      axios.post('http://localhost:7777/board/search', {searchBoard})
            .then((res) => {
              console.log(res + '성공!')
              this.$store.commit(FETCH_BOARD_LIST, res.data);
            })
    }
  },
  mounted() {
    this.fetchBoardList()
  }
}
</script>

<style scoped>

</style>