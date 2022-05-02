<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
        <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 880px" class="pa-4">
          <DiaryPageList></DiaryPageList>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";
import DiaryPageList from "@/components/myPage/DiaryPageList";
export default {
  name: "MyPageDiary",
  components: {DiaryPageList, MenuList, MainCategory},

}
</script>

<style scoped>

</style>