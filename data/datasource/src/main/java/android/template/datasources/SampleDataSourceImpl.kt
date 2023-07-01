package android.template.datasources

internal class SampleDataSourceImpl : SampleDataSource {
    override fun getData(): List<Int> {
        return listOf(1, 2, 3)
    }
}
