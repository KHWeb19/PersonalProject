<template>
<div>
        <v-container>
         <v-row>
            <v-col v-for="tipBoard in paginatedData()" :key="tipBoard.boardNo">
               <v-card style="margin:10px; width: 250px; height: 300px;">              
               <v-toolbar dark>
                     <router-link :to="{ name: 'TipReadPage',
                                                params: { boardNo: tipBoard.boardNo.toString() } }">      
                  <v-toolbar-title>{{ tipBoard.title }}</v-toolbar-title>
                     </router-link>
               </v-toolbar>   

                     <v-card-text>{{ tipBoard.content }} </v-card-text>
                           <v-divider></v-divider>
               </v-card>
            </v-col>
         </v-row>
        </v-container>

      <v-row>
        <v-col>
          <div class="btn-cover">
            <v-btn :disabled="pageNum === 0" @click="prevPage" class="page-btn">
              이전
            </v-btn>
            <span class="page-count"
              >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
            >
            <v-btn
              :disabled="pageNum >= pageCount - 1"
              @click="nextPage"
              class="page-btn"
            >
              다음
            </v-btn>
          </div>
        </v-col>
      </v-row>

</div>
</template>

<script>
export default {
    name: 'TipBoardList',
    props: {
        tipBoards: {
            type: Array
        },
        listArray: {
        type: Array,
        required: true,
        },
        pageSize: {
        type: Number,
        required: false,
        default: 16,
        },
    },
    data() {
        return {
        pageNum: 0,
        };
    },
    method: {
        nextPage() {
        this.pageNum += 1;
        },
        prevPage() {
        this.pageNum -= 1;
        }
    },
    computed: {
        pageCount() {
        let listLeng = this.listArray.length,
            listSize = this.pageSize,
            page = Math.floor(listLeng / listSize);
        if (listLeng % listSize > 0) page += 1;
        return page;
        },
        paginatedData() {
        const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
        return this.listArray.slice(start, end);
        },
    },
};

</script>

<style scoped>
table {
    margin: 10px;
    width: 30%;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>