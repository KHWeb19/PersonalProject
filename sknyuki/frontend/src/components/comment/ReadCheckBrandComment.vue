<template>

  <v-card class="mb-10" >
    <add-check-brand-comment :boardNo="boardNo"/>

    <v-card v-if="!checkbrandComments || (Array.isArray(checkbrandComments) && checkbrandComments.length ===0)" 
      class="pa-5"  flat>
      <p class="ma-2">등록된 댓글이 없습니다.</p>
    </v-card>

    <v-card v-else v-for="item in checkbrandComments" :key="item.commentNo" class="mx-4" flat>
      <v-list >
        <v-list-item>
          <v-list-item-avatar>
            {{ item.id }}
          </v-list-item-avatar>
          
          
              <v-list-item >
                {{ item.content }}
              </v-list-item>
           
          
          <v-menu offset-y>
            <template v-slot:activator="{ on }">
              <v-btn v-if="userInfo.id == item.id" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>

              <modify-check-brand-comment :commentNo="item.commentNo" :boardNo="boardNo"/>

              <v-list-item @click="removeDialog(item.commentNo)">
                삭제
              </v-list-item>
            </v-list>
          </v-menu>
          
        </v-list-item>
      </v-list>
      <v-divider></v-divider>
    </v-card>

    <v-dialog v-model="dialog" max-width="350">
      <v-card class="rounded-xl pa-4">
        <v-card-title class="secondary--text font-weight-bold">
          <p>정말 삭제하시겠습니까?</p>
        </v-card-title>

        <v-card-text></v-card-text>

        <v-card-actions>
          <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
            Cancle
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnRemove" class="secondary--text font-weight-bold" text>
            Delete
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

  </v-card>  
</template>


<script>
import AddCheckBrandComment from '@/components/comment/AddCheckBrandComment'
import ModifyCheckBrandComment from '@/components/comment/ModifyCheckBrandComment'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    AddCheckBrandComment,
    ModifyCheckBrandComment
  },
  name:'ReadCheckBrandComment',
  props: {
    boardNo: {
      type: String,
            required: true
    }
  },
  data () {
    return {
      dialog: false,
      commentNo: null
    }
  },
  computed: {
    ...mapState([ 'checkbrandComments', 'userInfo' ])
  },
  mounted () {
    this.fetchCheckBrandComments(this.boardNo)
  },
  methods: {
    ...mapActions([ 'fetchCheckBrandComments', 'fetchCheckBrandComment' ]),

    removeDialog (commentNo) {
      this.dialog = true
      this.commentNo = commentNo
    },
    btnCancle () {
      this.dialog = false
    },
    btnRemove () {
      axios.delete(`http://localhost:7777/BrandCheck/comment/remove/${this.commentNo}`).then(() => {
        alert('댓글이 삭제되었습니다!')

        this.fetchCheckBrandComments(this.boardNo)

        this.dialog = false
      })
    },
  }
}
</script>