<template>
    <body>
      <v-container>
      <form @submit.prevent="onSubmit"/>
        <h1>고객의 소리</h1><br>
        <div id = 'btn'>
        <v-btn class='white--text' id = 'btnRegisterPage'
        :to="{ name: 'BoardRegisterPage' }">글등록</v-btn>
        </div><br>
         <v-row justify="center">
           <v-col xs="24" sm="12" md="12">
             <v-card class="pa-3">
               <v-subheader style="dark">
                 <v-text-field
                    v-model="keyword"
                    append-icon="mdi-magnify"
                    label="Search"
                    single-line
                    hide-details>
                 </v-text-field>
               </v-subheader>
                    <v-divider :inset="false"></v-divider>
                      <v-data-table
                          :search="keyword"
                          :headers="headers"
                          :items="boards"
                          :key="boards.boardNo"
                          :page.sync="page"
                          :items-per-page="itemsPerPage"
                          hide-default-footer
                          class="elevation-1"
                          @page-count="pageCount = $event"
                      >
                        <template v-slot:[`item.title`]="{ item }">
                        <router-link style="color: black" :to="{ name: 'BoardReadPage',
                                        params: { boardNo: item.boardNo } }">
                             {{ item.title }}
                        </router-link>
                        </template>
                      </v-data-table>
                      <div class="text-center pt-2">
                        <v-pagination
                          v-model="page"
                          :length="pageCount"></v-pagination>
                      </div>
                 </v-card>
            <br><br><br>
          </v-col>
        </v-row>
      </v-container>
    </body>
</template>

<script>
export default {
  name: 'BoardList',
  props: {
    boards: {
      type: Array
    }
  },
  data () {
    return {
      page: 1,
      pageCount: 0,
      itemsPerPage: 10,
      totalVisible: 10,
      keyword: '',
      headers: [
        { text: '번호', value: 'boardNo' },
        { text: '제목', value: 'title' },
        { text: '작성자', value: 'writer' },
        { text: '등록일자', value: 'regDate', width: '160px' }
      ]
    }
  }
}
</script>

<style scoped>
#btn { text-align: right; font-size: 18px;}
#btnRegisterPage { background:navy;}
.inputSearch {
    width: 80%;
    height: 40px;
    border-radius: 20px;
    border: 1px solid #bbb;
    margin: 10px 0;
    padding: 10px 12px;
}
input:focus { outline-color: blue; }
</style>
