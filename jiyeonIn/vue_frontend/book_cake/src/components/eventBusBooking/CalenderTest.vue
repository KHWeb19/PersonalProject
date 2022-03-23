<template>
    <div class="celander">
        <v-row justify="left">
            <v-date-picker v-model="picker" color="pink"></v-date-picker>
        </v-row>
        <v-row></v-row>
        
  </div>
</template>

<script>
  export default {
    data () {
      return {
        picker: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      }
    },
  }
</script>

<style scoped>
.celander {
    padding: 3px;
    font-size: 3;
}
</style>