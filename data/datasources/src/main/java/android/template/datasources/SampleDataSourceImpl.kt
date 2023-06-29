package android.template.datasources

class SampleDataSourceImpl : SampleDataSource {
    override fun getData(): List<Int> {
        return listOf(1, 2, 3)
    }
}
