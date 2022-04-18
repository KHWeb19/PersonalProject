<template>
  <v-container>
    <form>
      <table>
        <tr v-if="!dayContent || (Array.isArray(dayContent) && dayContent.length === 0)">
          <td colspan="3">
            등록된 내용이 없어요!
          </td>
        </tr>
        <tr v-for="(day, index) in dayContent" :key="index">
          <table align="center" width="100%" border="1">
            <tr>
              <td>
                {{day.id}}
              </td>
            </tr>
            <tr>
              <td>
                {{day.content}}
              </td>
            </tr>
          </table>
        </tr>
      </table>
    </form>
  </v-container>
</template>

<script>
export default {
  name: "ContentList",
  props: {
    dayContent: {
      type: Array,

    }
  }
}
</script>

<style scoped>
td{
  font-size: 35px;
}
</style>