<template>
  <v-container>
    <SearchIdPw @searchId="searchId" @searchPw="searchPw"></SearchIdPw>
  </v-container>
</template>

<script>
import SearchIdPw from "@/components/login/SearchIdPwForm";
import axios from "axios";

export default {
  name: "IdPwSearchPage",
  components: {SearchIdPw},
  methods:{
    searchId(payload){
      const {nameId, birth} =  payload;
      let name = nameId
      //alert(name + ', '+ birth)
      axios.put('http://localhost:7777/search/id', {name, birth})
        .then((res) => {

          if(res.data.id === null) {
            alert('찾으시는 아이디가 없습니다!')
          }else{
            alert('찾는 아이디는  : \' ' + res.data.id + ' \' 입니다. ');
          }

        })
      .catch(() => {
        alert('실패!')
      })
    },
    searchPw(payload){
      const {namePw, id} = payload;
      let name = namePw;

      axios.put('http://localhost:7777/search/pw', {name, id})
        .then((res) => {
          //alert('성공' + res.data)

          if(res.data === true){
            //alert(id)
            this.$router.push({name: 'ChangePw', params: {id: id}});
          }else{
            alert('찾으시는 비밀번호가 없습니다.')
          }
        })
    }

  }
}
</script>

<style scoped>

</style>