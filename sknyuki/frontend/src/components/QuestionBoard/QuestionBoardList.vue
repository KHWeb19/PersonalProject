<template>
<div>
 
<v-container fluid>
      <v-divider></v-divider>
      <br>
      <v-row align="center">
    
        <v-col
          cols="12"
          sm="6"
        >
          <v-subheader v-text="'select the Brand What you want to check'"></v-subheader>
        </v-col>
  
        <v-col
          cols="12"
          sm="6"
        >
          <v-select
            v-model="e7"
            :items="states"
            label="Select"
            chips
            hint="What is the target Brand"
            persistent-hint
          ></v-select>
        </v-col>
      </v-row>
    <v-row align="center" justify="center" >
       <v-btn width="400"
    class="blue lighten-5" 
    @click="datasubmit">검색</v-btn>
    </v-row>
    </v-container>
    <br>
    <v-divider></v-divider>

    <v-card>
        <v-card-title>
          <v-spacer></v-spacer>
          <v-text-field 
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details></v-text-field>
        </v-card-title>
                
              <v-data-table
                :headers="headerTitle"
                :items="QuestionBoards"
                :search="search"
                :key="QuestionBoards.boardNo"
                :items-per-page="10"
                class="elevation-1" >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'K1QuestionReadPage',
                                        params: { boardNo: item.boardNo.toString() } }">
                    {{ item.title }}
                   </router-link>
                </template>   
            ></v-data-table>
    </v-card>
                 <br>
      <v-row  justify="end">
    <router-link style="text-decoration: none;" :to="{name:'K1QuestionRegisterPage'}">
    <v-btn class="blue lighten-5">
      <v-icon small>mdi-pencil</v-icon> 글쓰기</v-btn>
    </router-link></v-row>
    <br>
</div>


</template>

<script>
export default {
    name:'QuestionBoardList',
    props:{
      QuestionBoards: []
    },
  data () {
    return {
      search:'',
            headerTitle: [
                            { text: '번호', value: 'boardNo', width: "70px" },
                            { text: '종류', value: 'type', width: "70px" },
                            { text: '제목', value: 'title', width: "200px" },
                            { text: '작성자', value: 'writer', width: "50px" },
                            { text: '등록일자', value: 'regDate', width: "60px" }
                        ],
                        e7:[],
                         states: [
        'HEMES', 'VITTON', 'CHANEL', 'GUCCI',
        'FENDI', 'PRADA', 'Dior', 'VANCLEE',
        'Tiffany', 'Cartier', 'bottega',
        'YSL', 'Supreme', 'BURBERRY', 'THOM', 'BALENCIAGA',
        'ROLEX', 'IWC', 'PIAGET', 'OMEGA', 'TAG','Others'
      ],
    }
  },
    methods: {
      datasubmit () {
            this.search=this.e7      
      }
    }
}
</script> 

